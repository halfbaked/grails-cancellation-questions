
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"

grails.project.dependency.resolver = "maven" // maven or ivy

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
	    mavenLocal()
	    mavenCentral()
	    //mavenRepo "http://artifactory.saasplex.com/artifactory/repo"
	    //mavenRepo "http://repo2.maven.org/maven2/"
	    mavenRepo "http://artifactory.saasplex.com/repo"
	    //mavenRepo "http://repo1.maven.org/maven2/"
	    mavenRepo "https://oss.sonatype.org/content/repositories/releases/"
	    grailsPlugins()
	    grailsHome()
	    grailsCentral() 
	    //grailsRepo "http://grails.org/plugins"
	    mavenRepo "http://maven.springframework.org/milestone/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.18'
    }

    plugins {
        build(":tomcat:7.0.42",":release:3.0.1",":rest-client-builder:1.0.2") {
            export = false
        }
        test(":spock:0.7", ":code-coverage:1.2.5", ":build-test-data:2.0.3"){
          export = false
        }
        compile ":build-test-data:2.0.8"
        runtime ":hibernate:3.6.10.6"
        compile ":ckeditor:3.6.3.0"
        compile ":resources:1.2.RC2"
        compile ":platform-core:1.0.RC6"
        runtime ":jquery:1.8.0"

        runtime(":database-migration:1.3.5"){
          export = false
        }
    }
}
