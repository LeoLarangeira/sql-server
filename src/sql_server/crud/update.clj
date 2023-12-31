(ns sql-server.crud.update
  (:require [clojure.java.jdbc :as jdbc]
            [sql-server.components.db :as db]
            [honeysql.format :as honey]))



(defn update-user! [id name]
  ; This function updates the name of a user in the "user" table using JDBC.
  ; It utilizes the provided database connection (db/db) and a parameterized SQL
  ; UPDATE statement generated by the honey library. The user with the specified
  ; id is identified in the WHERE clause, and the name is set to the provided value.
  (jdbc/execute! db/db (honey/format {:update :user
                                      :set {:name name}
                                      :where [:= :id_user id]})))

