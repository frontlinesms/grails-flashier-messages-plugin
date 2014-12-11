grails.project.work.dir = 'target'
grails.project.target.level = 1.6

grails.project.dependency.resolution = {
	inherits 'global'
	log 'warn'
	repositories {
		grailsHome()
		mavenLocal()
		grailsCentral()
		mavenCentral()
		mavenRepo 'http://dev.frontlinesms.com/m2repo/'
	}
	dependencies {
	}

	plugins {
		build ':release:2.2.1',
				':rest-client-builder:1.0.3', {
			export = false
		}

		test ':spock:0.7', {
			exclude "spock-grails-support"
		}
		test ':hibernate:2.2.1', ':tomcat:2.2.1'

		compile ":one-time-data:1.2-frontlinesms"
	}
}
