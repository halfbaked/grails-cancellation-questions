class CancellationQuestionsUrlMappings {

	static mappings = {
    "/api/cancellationAnswer/$id?"{
      parseRequest = true
      controller = "cancellationAnswerApi"
      action = {
        switch (request.method){
          case "GET":
            if (params.id) return "show"
            else return "list"
          case "POST":
            return "create"
        }
      }
    }
  }

}
