(ns sql-server.routes
  (:require [compojure.core :refer [GET POST PUT DELETE defroutes]]
            [compojure.route :as route]
            [sql-server.crud.search :as search]
            [sql-server.crud.update :as up]
            [sql-server.crud.delete :as del]
            [sql-server.handlers.handler :as handler]))



(defroutes routes
  ;; GET request to retrieve information about five users
  (GET "/users" [req]
    (search/get-five-users))

  ;; POST request to create a new user
  (POST "/users" [req]
    (handler/create-user)
    "User created successfully") ; A success message returned to the client

  ;; PUT request to update a user's information
  (PUT "/users/:id/:name" [id name]
    (up/update-user! id name)
    "<h1>User updated successfully</h1>") ; A success message returned to the client

  ;; DELETE request to delete a user
  (DELETE "/users/:id" [id]
    (del/delete-user! id))

  ;; Catch-all route for any other requests
  (route/not-found "<h1>Not Found</h1>"))
