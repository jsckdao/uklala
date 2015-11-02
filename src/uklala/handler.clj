(ns uklala.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.util.response :refer [content-type get-header]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defroutes app-routes
  ;;(GET "/" [] "Hello World")
  (route/resources "/")
  (route/not-found "Not Found"))

(defn create-event-link
  "处理事件推送服务请求"
  [req]
  (do (print req) {:status 200
   :headers {"Content-Type" "text/event-stream;charset=utf-8"}
   :body "Hello World"}))

(defn wrap-event-link
    "中间件: 处理html5 服务器事件推送服务访问请求"
  [handler]
  (fn [req]
    (if (= (get-header req "Accept") "text/event-stream")
      (create-event-link req)
      (handler req))))



(def app
  (wrap-defaults (wrap-event-link app-routes) site-defaults))


(defn testa [a b]
  (+ a b))
