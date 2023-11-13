(ns sql-server.crud.search
  (:require [sql-server.components.db :as db]
            [honeysql.format :as honey]
            [clojure.java.jdbc :as jdbc]
            [cheshire.core :refer :all]
            [honeysql.core :as sql]))

;select all the first five users 

;select * from users LIMIT 5

(defn get-five-users []
  
  (let [query '{:select [:*], :from [:user], :limit :5}
        result (jdbc/query db/db (honey/format query))
        _ (println result)
        string-body (generate-string (str result))
        _ (println string-body)]
    
    {
     :status 200 
     :headers  {"Content-Type" "application/json; charset=utf-8"}
     :body result
    }
    )
  )

#_(jdbc/query db/db "select * from user;")
