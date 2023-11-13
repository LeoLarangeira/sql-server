(ns sql-server.crud.insert
  (:require [honeysql.format :as honey]
            [honeysql.core :as sql]
            [clojure.java.jdbc :as j]
            [faker.name :as fkn]
            [faker.company :as fkc]))
(def f-name (fkn/first-name))
(def email (str f-name"@test.com"))
email

;(def name (str (fkn/first-name)" " (fkn/last-name)))


;(def email (str name "@" (fkc/names)))

