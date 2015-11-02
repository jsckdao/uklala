(ns uklala.boot
  (:require [org.httpkit.server :refer :all]
            [compojure.route :refer [files not-found]]
            [compojure.handler :refer [site]]
            [compojure.core :refer [defroutes GET POST DELETE ANY context]]))


(defn chat-handler [request]
  (with-channel req channel
    (on-close channel (fn [status]
                        (println "channel closed")))
    (if (websocket? channel)
      (println "WebSocket channel")
      (println "HTTP channel"))
    (on-receive channel (fn [data]
                          (send! channel data)))))

(defroutes all-routes
  (GET "/" []
       {:status 200
        :headers {"Content-Type" "text/event-stream;charset=utf-8"}
        :body "Hell"})
  
  (GET "/chat" [] chat-handler) 

  (route/resources "/static/") 
  (route/not-found "<p>Page not found.</p>"))


(run-server (site #'all-routes) { :port 3100 })
