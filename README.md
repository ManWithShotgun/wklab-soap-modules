Запуск tomcat через плагин maven -> cxf-soap -> tomcat: run

tomcat: http://localhost:9999/cxf-soap/cxf/soap?wsdl


cxf-soap(osgi karaf):
http://localhost:8181/system/console/bundles
http://localhost:8181/cxf/  ----- http bundle (list cxf services)

install -s mvn:ru.ilia/osgi-blueprint/1.0-SNAPSHOT

kar:install mvn:ru.ilia/osgi-feature/1.0-SNAPSHOT
mvn:ru.ilia/osgi-feature/1.0-SNAPSHOT