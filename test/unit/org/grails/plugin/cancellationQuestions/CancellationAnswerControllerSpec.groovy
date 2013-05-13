package org.grails.plugin.cancellationQuestions


import grails.test.mixin.*
import grails.buildtestdata.mixin.Build


@TestFor(CancellationAnswerController)
@Build([CancellationAnswer])
@Mock([CancellationAnswer])
class CancellationAnswerControllerSpec extends spock.lang.Specification {

  def setup(){
  }

  def "test list"(){

    given: "a sample cancellation answer"
      def cancellationAnswer = CancellationAnswer.build()      

    when: "we call the list action"
      def model = controller.list()

    then: "the particular cancellation answer will be included in the model"
      model.cancellationAnswers.any { it.id == cancellationAnswer.id }
  }

  def "test update where user wants to see the edit screen"(){

    given: "a sample cancellation answer"
      def cancellationAnswer = CancellationAnswer.build()

    when: "we call the update action and the HTTP method is GET"
      controller.request.method = 'GET'
      controller.params.id = cancellationAnswer.id
      def model = controller.update()

    then: "the model should contain the cancelation answer to update"
      model.cancellationAnswer.id == cancellationAnswer.id
  }

  def "test update where user wants to save their changes"(){

    given: "a sample cancellation answer"
      def cancellationAnswer = CancellationAnswer.build()

    when: "we call the update action and the HTTP method is POST and we update the data"
      def newTitle = "new answer title" 
      def newBody = "new answer body"
      controller.request.method = 'POST'
      controller.params.title = newTitle
      controller.params.body = newBody
      controller.params.id = cancellationAnswer.id
      controller.update()      
      cancellationAnswer = CancellationAnswer.get(cancellationAnswer.id)

    then: "the title of the cancellation answer will have been updated"
      cancellationAnswer.title == newTitle
      cancellationAnswer.body == newBody
  }

  def "test update of data where validation should fail"(){

    given: "a sample cancellation answer"
      def cancellationAnswer = CancellationAnswer.build()

    when: "we call the update action and the HTTP method is POST and we update the data"
      controller.request.method = 'POST'
      controller.params.title = "" 
      controller.params.id = cancellationAnswer.id
      def model = controller.update()      

    then: "the model has the cancellation answer which will have errors"
      model.cancellationAnswer.id == cancellationAnswer.id
      model.cancellationAnswer.hasErrors()
  }

  def "test add new cancellation answer"(){

    given: "there are suitable params in the request"
      def title = "Great title"
      def body = "Great body"
      def accountName = "Tommy Toomes, Opal Inc."
      def accountEmail = "tommy@opal.inc"
      controller.params.title = title
      controller.params.body = body
      controller.params.accountName = accountName
      controller.params.accountEmail = accountEmail

    when: "we call the add action"
      controller.add()      

    then: "the cancellation answer will have been created"
      CancellationAnswer.findByTitleAndBody(title,body)
  }

  def "test deletion of cancellation answer"(){

    given: "an existing cancellation answer"
      def cancellationAnswer = CancellationAnswer.build()

    when: "we call the delete action and provide the id"
      controller.params.id = cancellationAnswer.id
      controller.delete()

    then: "the cancellation answer no longer exists"
      !CancellationAnswer.get(cancellationAnswer.id)

  }

}
