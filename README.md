# Cancellation Questions Plugin

The Cancellation Questions enables you to quickly add the functionality to ask questions to users when they are leaving your application.

## Creating Questions

There is a crud controller and view all ready to go. Navigate to $serverUrl/cancellationQuestion/list
There  you can view, add, edit, and delete the cancellation questions you ask your customers.

## Reviewing Answers

There is also a crud controller for answers ready to go. Navigate to $serverUrl/cancellationAnswer/list
There you can review and edit existing answers, manually add new answers, and delete the answers you don't like ;)

## Asking Questions

Typically to integration the asking of the questiosn into your process you need to add to two definitions to the respective view in your own app. 

### Javascript Resource

To include the javascript resource define the following in the head of your view: 

     <r:require module="cancellationQuestions" />


### Tag

The tag you need to define looks something like this

    <cancellationQuestions:ask action="cancel" controller="customerAccount" accountName="Bob Hoskins, Bob Inc" accountEmail="bobhoskins@gmail.com">
      We have no cancellation Questions for you. 
      <g:link action="justCancel" controller="customerAccount" >Just cancel</g:link>
    </cancellationQuestions>

* action - the action of the controller to be called in order to complete the cancellation process
* controller - the controller to be called in order to complete the cancellation process
* accountName - the name of the account which is being cancelled
* accountEmail - the email of the account being cancelled
* body - in the body of the tag, you can define an alternative that is shown to users if no cancellation questions exist. 

