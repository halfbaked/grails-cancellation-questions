package org.grails.plugin.cancellationQuestions

import grails.test.mixin.*
import grails.buildtestdata.mixin.Build


@TestFor(CancellationAnswerApiController)
@Build([CancellationAnswer])
@Mock([CancellationAnswer])
class CancellationAnswerApiControllerSpec extends spock.lang.Specification {

  def setup(){
    controller.request.format = 'json'
  }

  def "test create"(){   
    given: "there are suitable params in the request"
      def title = "Great title"
      def body = "Great body"
      controller.request.json = "{ 'body': '$body', 'title': '$title'}".toString()

    when: "we call the add action"
      controller.create()      

    then: "the status code is 201 and the question has been created"
      controller.response.status == 201
      CancellationAnswer.findByTitleAndBody(title,body)
  }

}
