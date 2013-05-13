import org.grails.plugin.cancellationQuestions.*

class CancellationQuestionsBootStrap {

  def init = { servletContext ->
    CancellationAnswer.build()
  }

  def destroy = {
    
  }

}

