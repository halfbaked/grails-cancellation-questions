package org.grails.plugin.cancellationQuestions


class CancellationAnswer {

  Date createdDate = new Date()
  Date lastUpdated

  String title
  String body

  String accountName
  String accountEmail

  static constraints = {
    title blank:false
    body nullable:true
  }

  static mapping = {
    title type:'text'
    body type:'text'
  }

}
