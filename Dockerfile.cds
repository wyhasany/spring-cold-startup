FROM bellsoft/liberica-openjdk-debian:21.0.1-cds as build
COPY . /data/
RUN apt-get install --no-install-recommends -y unzip
RUN cd /data && ./cds.sh -b


FROM bellsoft/liberica-openjdk-debian:21.0.1-cds
COPY --from=build /data/build/unpacked /data/build/unpacked
COPY src/scripts/entrypoint-cds.sh /data/entrypoint.sh

ENTRYPOINT /data/entrypoint.sh