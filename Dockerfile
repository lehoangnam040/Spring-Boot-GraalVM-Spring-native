# https://github.com/orgs/graalvm/packages/container/package/graalvm-ce image
FROM ghcr.io/graalvm/graalvm-ce:21.1.0

# For SDKMAN to work we need unzip & zip
RUN microdnf install -y unzip zip

RUN \
    # Install SDKMAN
    curl -s "https://get.sdkman.io" | bash; \
    source "$HOME/.sdkman/bin/sdkman-init.sh"; \
    sdk install maven; \
    # Install GraalVM Native Image
    gu install native-image;

RUN source "$HOME/.sdkman/bin/sdkman-init.sh" && mvn --version

RUN native-image --version

WORKDIR /build
COPY pom.xml pom.xml
COPY src src

RUN source "$HOME/.sdkman/bin/sdkman-init.sh" && mvn -B clean package -P native-image --no-transfer-progress

RUN echo "******" && ls /build/target

# We use a Docker multi-stage build here in order that we only take the compiled native Spring Boot App from the first build container
FROM oraclelinux:8-slim

# Add Spring Boot Native app spring-boot-graal to Container
COPY --from=0 "/build/target/Service" spring-boot-graal

# Fire up our Spring Boot Native app by default
CMD [ "sh", "-c", "./spring-boot-graal -Dserver.port=8080" ]

