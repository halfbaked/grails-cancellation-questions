package org.grails.plugin.cancellationQuestions


import org.springframework.web.servlet.support.RequestContextUtils as RCU
import java.text.DateFormat


class CancellationQuestionController {

  def grailsApplication
  def exportService

  def list = {   
    def export = (params?.format && params.format != "html")
    def cancellationQuestions = CancellationQuestion.list(params)
    if(export) {
      response.contentType = grailsApplication.config.grails.mime.types[params.format]
      response.setHeader("Content-disposition", "attachment; filename=cancellationQuestions.${fileExtensions[params.format]}")
      List fields = [ "title", "body", "createdDate" ]
      Map labels = [ "createdDate":"Created Date", "title":"Title", "body":"Body" ]
      Map formatters = [ "createdDate":dateFormat ]
      Map parameters = [ title:"Cancellation Questions", "column.widths":[0.2, 0.4, 0.9] ]
      exportService.export(params.format, response.outputStream, cancellationQuestions, fields, labels, formatters, parameters)
    } else {
      [cancellationQuestions: cancellationQuestions]          
    }
  }

  def update = {
    try {
      def cancellationQuestion = CancellationQuestion.get(new Long(params.id))
      if (!cancellationQuestion){
        response.sendError(404)
      } else {     
        if (request.method == 'POST') { 
          cancellationQuestion.properties = params
          if (!cancellationQuestion.hasErrors() && cancellationQuestion.save(flush:true)){
            redirect action:'list'
          }
        }
        [cancellationQuestion: cancellationQuestion]
      } 
    } catch (NumberFormatException nfe) { 
      response.sendError(404)
    }
  }

  def add = {
    def cancellationQuestion = new CancellationQuestion()
    if(request.method != 'GET') {
      cancellationQuestion.properties = params
      if (!cancellationQuestion.hasErrors() && cancellationQuestion.save(flush:true)){
        redirect action:'list'
      }
    }
    [cancellationQuestion: cancellationQuestion]
  }

  def delete = {
    def cancellationQuestion = CancellationQuestion.get(params.id)
    if (!cancellationQuestion){
      response.sendError(404)
    } else {    
      cancellationQuestion.delete(flush:true)
      redirect action: 'list'
    } 
  }

  def dateFormat = { domain, value ->
    if (value) {
      DateFormat.getDateInstance(DateFormat.SHORT,RCU.getLocale(request)).format(value)
    }
  }

  def fileExtensions = [
    csv:'csv',
    excel:'xls',
    ods:'ods',
    pdf:'pdf',
    xml:'xml'
  ]

}
