package org.grails.plugin.cancellationQuestions


import grails.converters.JSON


class CancellationAnswerApiController {

  def create = {
    def cancellationAnswer = new CancellationAnswer(request.JSON)
    if(!cancellationAnswer.hasErrors() && cancellationAnswer.save()){
      response.status = 201
      render cancellationAnswer as JSON 
    } else {
      response.status = 400
      render "$cancellationAnswer.errors.allErrors"
    }
  }

  def show = {
    log.debug "show"
  }

  def list = {
    log.debug "list"
  }

}
