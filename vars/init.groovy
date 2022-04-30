#!groovy

def call(body) {
def pipelineParams = [:]
	body.resolveStrategy = Closure.DELEGATE_FIRST
	body.delegate = pipelineParams
	body()

        
            def TEST_STRING = "${pipelineParams.TEST_STRING}"
	    def BRANCH_NAME = "${pipelineParams.BRANCH_NAME}"
            def TEST_INT = "${pipelineParams.TEST_INT}"
            def TEST_ARR = "${pipelineParams.TEST_ARR}"
            def TEST_KEY_VALUE = "${pipelineParams.TEST_KEY_VALUE}"
            def TEST_KEY_VALUE_ONE = "${pipelineParams.TEST_KEY_VALUE.get('key1')}"
//             BUILD_VERSION = "${pipelineParams.projectVersion}-j${BUILD_NUMBER}"
//             PROJECT_PATH = "${pipelineParams.projectBase}"
//             PROJECT_NAME_RAW = "${pipelineParams.projectName}"
//             PROJECT_NAME = "${pipelineParams.projectName.get(env.BRANCH_NAME)}"
//             THEME_NAME = "${pipelineParams.themename}"
//             WEBSITE_NAME = "${pipelineParams.websitename}"
//             TARGET_HOST = "${pipelineParams.projectName.get(env.BRANCH_NAME)}@${pipelineParams.projectName.get(env.BRANCH_NAME)}.ssh.wpengine.net"
//             TARGET_SITE = "${pipelineParams.projectName.get(env.BRANCH_NAME)}.wpengine.com"
//             DOMAIN = "${pipelineParams.sites.get(env.BRANCH_NAME)}"
//             OLDDOMAIN = "${pipelineParams.domainstoreplace.get(env.BRANCH_NAME)}"
//             skipWebsiteCreation = "${pipelineParams.skipWebsiteCreation}"
//             quitDebugFor = "${pipelineParams.quitDebugFor}"
//             skipBuildPlugins = "${pipelineParams.skipBuildPlugins}"
//             skipBuildTheme = "${pipelineParams.skipBuildTheme}"
//             skipSeleniumTests = "${pipelineParams.skipSeleniumTests}"
       

pipeline {
    agent any
    options {
        buildDiscarder(logRotator(daysToKeepStr: '10', numToKeepStr: '10'))
        timeout(time: 12, unit: 'HOURS')
        timestamps()
    }
    triggers {
          cron '@midnight'
    }
    stages {
        stage('Initialize') {
            steps {
                echo 'Initializing..'
		echo "${BRANCH_NAME}"
                echo "${TEST_STRING}"
                echo "${TEST_INT}"
                echo "${TEST_ARR}"
                echo "${TEST_KEY_VALUE}"
                echo "${TEST_KEY_VALUE_ONE}"
            }
        }
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
}
