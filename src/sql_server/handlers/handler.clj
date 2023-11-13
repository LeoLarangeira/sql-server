(ns sql-server.handlers.handler
  (:require [compojure.core :refer :all]
            [sql-server.crud.insert :as i]
            [cheshire.core :refer :all]
            [faker.name :as fkn]
            [faker.address :as fka]))

(def user-name (fkn/first-name))
(def email (str user-name "@teste.com"))
(def address (fka/street-address))


(defn create-user []
  ;this function will recieve the req from routes and return a map with the new user
  (let [user (i/insert-user! user-name email address )
        _ (println user)
        user-string (generate-string user)
        _ (println user-string)]
    {
     :status 200
     :headers  {"Content-Type" "application/json; charset=utf-8"}
     :body user-string
    })
  )

(defn delete-user [id]
  ;this function will receive the id from the user and  will delete him
  )

(defn uptade-user-name [id name]
  ;this function will receive the id and the name that the user want to change
  )

(defn get-all-user []
  ;this function will return all the 5 first users
  )