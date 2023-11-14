(ns sql-server.crud.insert
  (:require [honeysql.format :as honey]
            [honeysql.core :as sql]
            [honeysql.helpers :refer :all]
            [clojure.java.jdbc :as jdbc] 
            [sql-server.components.db :as db]))







(defn insert-user! [name email address]
  ; This function inserts a new user into the "user" table using JDBC.
  ; It uses the provided database connection (db/db) and a parameterized SQL
  ; INSERT statement to add a new record with the given name, email, and address.
  (let [user (jdbc/execute! db/db
                            ["INSERT INTO user (name, email, address) VALUES (?, ?, ?)"
                             name email address])
        _ (println "insert user function" user)]))

;testing
#_(defn count-users []
  (let [total (jdbc/execute! db/db (honey/format {:select [:count :*] :from [:user]
                                                  }
                                                 ))
        ]
    (str  total)))
