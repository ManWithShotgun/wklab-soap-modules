1. wklab-soap-modules(root) -> install
2. osgi-feature -> package; (kar file is created in karaf/deploy)


cxf-soap(osgi karaf):
http://localhost:8181/system/console/bundles
http://localhost:8181/cxf/  ----- http bundle (list cxf services)

install -s mvn:ru.ilia/osgi-blueprint/1.0-SNAPSHOT --- example install bundle

kar:install mvn:ru.ilia/osgi-feature/1.0-SNAPSHOT
mvn:ru.ilia/osgi-feature/1.0-SNAPSHOT