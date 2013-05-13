package org.grails.plugin.cancellationQuestions


import grails.test.mixin.*
import grails.buildtestdata.mixin.Build


@TestFor(CancellationQuestionController)
@Build([CancellationQuestion])
@Mock([CancellationQuestion])
class CancellationQuestionControllerSpec extends spock.lang.Specification {

  def setup(){
  }

  def "test list"(){

    given: "a sample cancellation question"
      def cancellationQuestion = CancellationQuestion.build()      

    when: "we call the list action"
      def model = controller.list()

    then: "the particular cancellation question will be included in the model"
      model.cancellationQuestions.any { it.id == cancellationQuestion.id }
  }

  def "test update where user wants to see the edit screen"(){

    given: "a sample cancellation question"
      def cancellationQuestion = CancellationQuestion.build()

    when: "we call the update action and the HTTP method is GET"
      controller.request.method = 'GET'
      controller.params.id = cancellationQuestion.id
      def model = controller.update()

    then: "the model should contain the cancelation question to update"
      model.cancellationQuestion.id == cancellationQuestion.id
  }

  def "test update where user wants to save their changes"(){

    given: "a sample cancellation question"
      def cancellationQuestion = CancellationQuestion.build()

    when: "we call the update action and the HTTP method is POST and we update the data"
      def newTitle = "new question title" 
      def newBody = "new question body"
      controller.request.method = 'POST'
      controller.params.title = newTitle
      controller.params.body = newBody
      controller.params.id = cancellationQuestion.id
      controller.update()      
      cancellationQuestion = CancellationQuestion.get(cancellationQuestion.id)

    then: "the title of the cancellation question will have been updated"
      cancellationQuestion.title == newTitle
      cancellationQuestion.body == newBody
  }

  def "test update of data where validation should fail"(){

    given: "a sample cancellation question"
      def cancellationQuestion = CancellationQuestion.build()

    when: "we call the update action and the HTTP method is POST and we update the data"
      controller.request.method = 'POST'
      controller.params.title = "" 
      controller.params.id = cancellationQuestion.id
      def model = controller.update()      

    then: "the model has the cancellation question which will have errors"
      model.cancellationQuestion.id == cancellationQuestion.id
      model.cancellationQuestion.hasErrors()
  }

  def "test add new cancellation question"(){

    given: "there are suitable params in the request"
      def title = "Great title"
      def body = "Great body"
      controller.params.title = title
      controller.params.body = body

    when: "we call the add action"
      controller.add()      

    then: "the cancellation question will have been created"
      CancellationQuestion.findByTitleAndBody(title,body)
  }

  def "test deletion of cancellation question"(){

    given: "an existing cancellation question"
      def cancellationQuestion = CancellationQuestion.build()

    when: "we call the delete action and provide the id"
      controller.params.id = cancellationQuestion.id
      controller.delete()

    then: "the cancellation question no longer exists"
      !CancellationQuestion.get(cancellationQuestion.id)

  }

}
