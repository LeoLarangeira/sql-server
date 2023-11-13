(ns sql-server.crud.insert
  (:require [honeysql.format :as honey]
            [honeysql.core :as sql]
            [honeysql.helpers :refer :all]
            [clojure.java.jdbc :as jdbc] 
            [sql-server.components.db :as db]))




;(honey/format {:select [:count :*] :from [:user]})


(defn insert-user! [name email address]
  (let [user (jdbc/execute! db/db
                            ["INSERT INTO user (name, email, address) VALUES (?, ?, ?)"
                             name email address])
        _ (println "insert user function" user)])

  )

#_(defn count-users []
  (let [total (jdbc/execute! db/db (honey/format {:select [:count :*] :from [:user]
                                                  }
                                                 ))
        ]
    (str  total)))
