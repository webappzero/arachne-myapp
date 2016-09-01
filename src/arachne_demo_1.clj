(ns arachne-demo-1
  (:require [arachne.core :as arachne]
            [com.stuartsierra.component :as component]))

;; In a main function
(defn -main
  "Application entry point"
  [config-file & _]
  (let [cfg (arachne/build-config
              [:org.arachne-framework/arachne-pedestal]
              config-file)
        rt (arachne/runtime cfg :arachne-demo-1/runtime)]

    (component/start rt)))



;; From the REPL
(comment

  (def cfg (arachne/build-config
             [:org.arachne-framework/arachne-pedestal]
             "config/simple.clj"))

  (def rt (atom
            (arachne/runtime cfg :arachne-demo-1/runtime)))

  (swap! rt component/start)
  (swap! rt component/stop)
  )

(comment
  ;; explore the config...

  (require '[datomic.api :as d])

  (d/q '[:find ?e ?n
           :in $
           :where
           [?e :arachne.http.endpoint/name ?n]]
      (:db cfg))

  )
