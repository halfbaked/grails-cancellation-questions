package org.grails.plugin.cancellationQuestions

class CancellationQuestion {

  Date createdDate = new Date()
  Date lastUpdated

  String title 
  String body

  static constraints = {
    title blank:false
    body nullable:true
  }

  static mapping = {
    body type:'text'
    title type:'text'
  }

}
