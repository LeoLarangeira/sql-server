(ns sql-server.crud.search
  (:require [sql-server.components.db :as db]
            [honeysql.format :as honey]
            [clojure.java.jdbc :as jdbc]
            [cheshire.core :refer :all]
            [honeysql.core :as sql]
            [sql-server.dto.convert :as convert]))


(defn get-five-users []
  ; This function retrieves information for up to five users from the "user" table using JDBC.
  ; It constructs a query using the honey library, specifying the SELECT and FROM clauses,
  ; and limits the result to five rows. The result is then returned as a JSON response.
  (let [query '{:select [:*], :from [:user], :limit :5}
        result (jdbc/query db/db (honey/format query))
        _ (println (type result))]

    {:status 200
     :headers {"Content-Type" "application/json; charset=utf-8"}
     :body result}))

#_(honey/format {:select [:*] :from [:user] :where [:= :id 2]})


(defn get-user-id [id]
  ; This function retrieves information for a user with the specified id from the "user" table using JDBC.
  ; It constructs a query using the honey library, specifying the SELECT and FROM clauses,
  ; and filtering the result based on the provided id. The result is then returned as a JSON response.
  (let [result (jdbc/query db/db (honey/format {:select [:*] :from [:user] :where [:= :id id]}))
        _ (println result)]
    (generate-string result)))


(defn get-user-dto-id [id]
  (->> (jdbc/query db/db (honey/format {:select [:*] :from [:user] :where [:= :id_user id]}))
       (ffirst)
       (convert/user->dto)))