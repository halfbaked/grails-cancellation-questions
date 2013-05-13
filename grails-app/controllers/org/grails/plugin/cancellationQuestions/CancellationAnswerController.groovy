package org.grails.plugin.cancellationQuestions


import org.springframework.web.servlet.support.RequestContextUtils as RCU
import java.text.DateFormat


class CancellationAnswerController {

  def grailsApplication
  def exportService

  def list = {               
    def export = (params?.format && params.format != "html")
    if(!export) params.max = 30  
    def cancellationAnswers = CancellationAnswer.createCriteria().list(params) {
        if(params.title){ ilike 'title', "%${params.title}%"}
    }
    if(export) {
      response.contentType = grailsApplication.config.grails.mime.types[params.format]
      response.setHeader("Content-disposition", "attachment; filename=cancellationAnswers.${fileExtensions[params.format]}")
      List fields = [ "title", "accountName", "body", "createdDate" ]
      Map labels = [ "title":"Title", "accountName":"Account Name", "createdDate": "Created Date"]
      Map formatters = [ "createdDate":dateFormat ]
      Map parameters = [ title:"Cancellation Questions", "column.widths":[0.4, 0.3, 0.9, 0.2] ]
      exportService.export(params.format, response.outputStream, cancellationAnswers, fields, labels, formatters, parameters)
    } else {
      [cancellationAnswers: cancellationAnswers]          
    }
  }

  def update = {
    try {
      def cancellationAnswer = CancellationAnswer.get(new Long(params.id))
      if (!cancellationAnswer){
        response.sendError(404)
      } else {     
        if (request.method == 'POST') { 
          cancellationAnswer.properties = params
          if (!cancellationAnswer.hasErrors() && cancellationAnswer.save(flush:true)){
            redirect action:'list'
          }
        }
        [cancellationAnswer: cancellationAnswer]
      } 
    } catch (NumberFormatException nfe) { 
      response.sendError(404)
    }
  }
  
  def add = {
    def cancellationAnswer = new CancellationAnswer()
    if(request.method != 'GET') {
      cancellationAnswer.properties = params
      if (!cancellationAnswer.hasErrors() && cancellationAnswer.save(flush:true)){
        redirect action:'list'
      }
    }
    [cancellationAnswer: cancellationAnswer]
  }

  def delete = {
    def cancellationAnswer = CancellationAnswer.get(params.id)
    if (!cancellationAnswer){
      response.sendError(404)
    } else {    
      cancellationAnswer.delete(flush:true)
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
