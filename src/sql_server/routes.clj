(ns sql-server.routes
  (:require [compojure.core :refer [GET POST PUT DELETE defroutes]]
            [compojure.route :as route]
            [sql-server.crud.search :as search]
            [sql-server.crud.update :as up]
            [sql-server.crud.delete :as del]
            [sql-server.handlers.handler :as handler]))



(defroutes routes
  (GET "/users" [req] 
    (search/get-five-users )) 
  (POST "/users"[req] ""
    (handler/create-user))
  (PUT "/users/:id/:name" [id name] ""
    (up/update-user! id name))
  (DELETE "users-delete/:id" [id] ""
    (del/delete-user! id))
  (route/not-found "<h1> Não conseguir achar </h1>"))