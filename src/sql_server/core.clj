(ns sql-server.core
  (:gen-class)
  (:require [sql-server.components.db :as db]
            [sql-server.routes :as r]
            [ring.adapter.jetty :as jetty]))

(defn -main
  []
  ;; Start the database
  (db/start-db)

  ;; Run the Jetty server with specified routes and configurations
  (jetty/run-jetty r/routes
                   {:port 8000        ;; Set the server port to 8000
                    :join? true       ;; Wait for the server to join before returning
                    :daemon? true}))  ;; Run the server as a daemon process

