(ns sql-server.handlers.handler
  (:require [compojure.core :refer :all]
            [sql-server.crud.insert :as i]
            [sql-server.crud.update :as up]
            [sql-server.crud.delete :as del]
            [sql-server.crud.search :as sc]
            [cheshire.core :refer :all]
            [faker.name :as fkn]
            [faker.address :as fka]
            [clojure.java.jdbc :as jdbc]
            [sql-server.crud.search :as search]))

(def user-name (fkn/first-name))  ; Assuming fkn is a namespace for functions related to first names
(def email (str user-name "@teste.com"))
(def address (fka/street-address))  ; Assuming fka is a namespace for functions related to street addresses

(defn create-user []
  ; This function will receive a request from routes and return a map with the new user
  (let [user (i/insert-user! user-name email address) 
       counted (i/count-users)]
    {:status 200
     :headers {"Content-Type" "application/json; charset=utf-8"}
     :body (str "Usuário inserido com sucesso, temos um total de:" counted " usuarios")}))

(defn delete-user [id]
  ; This function will receive the id from the user and will delete them
  (let [deleted-user (del/delete-user! id)]
    {:status 200
     :headers {"Content-Type" "application/json; charset=utf-8"}
     :body (str "Usuário deletado com sucesso")}))

(defn uptade-user-name [id name]
  ; This function will update the user's name based on the provided id
  (let [update-user (up/update-user! id name)
        new-user (search/get-user-id id)]
    {:status 200
     :headers {"Content-Type" "application/json; charset=utf-8"}
     :body new-user}))


(defn search-user [id]
  (let [user (sc/get-user-dto-id id) ; Assuming this function retrieves a user by ID
        user-str (str user)            ; Convert the user to a string
        response {:status 200           ; Create the response map
                  :body user-str}]
    (println "user->" user)            ; Optional: Print information for debugging
    (println "type->" (type user))
    (println "convert->" user-str)
    (println "convert->type" (type user-str))
    response))                         ; Return the response map
