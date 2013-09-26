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
    accountName nullable:true
    accountEmail nullable:true
  }

  static mapping = {
    title type:'text'
    body type:'text'
  }

  def afterInsert(){
    event(for:"cancellationQuestions", topic: "cancellationAnswerCreated", data: this)
  }

  // Returns a map representation used in email templates
  Map asDataMap(){
    [
      account_name: accountName,
      account_email: accountEmail,
      title: title,
      body: body
    ]
  }

}
