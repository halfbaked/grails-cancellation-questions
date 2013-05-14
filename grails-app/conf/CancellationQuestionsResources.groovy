modules = {
  cancellationQuestions {
    dependsOn 'jquery'
    resource url: [plugin: "cancellation-questions", dir:"css", file:"cancellation-questions.css"]
    resource url: [plugin: "cancellation-questions", dir:"js", file:"cancellation-questions.js"]
  }
}
