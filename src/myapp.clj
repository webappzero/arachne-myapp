(ns myapp
  (:require [arachne.core :as arachne]
            [com.stuartsierra.component :as component]))

;; In a main function
(defn -main
  "Application entry point"
  [config-file & _]
  (let [cfg (arachne/build-config
             [:org.arachne-framework/arachne-core]
              config-file)  ;; ??? Is the output of build config
                             ;;     always THE final config value?
        rt (arachne/runtime cfg :myapp/runtime)]

    (component/start rt)))

;; ??? How can I tell, programmatically, if a runtime is started vs stopped?


;; From the REPL
(comment

  (def cfg (arachne/build-config
             [:org.arachne-framework/arachne-pedestal]
             "config/simple.clj"))

  (def rt (atom
            (arachne/runtime cfg :myapp/runtime)))

  (swap! rt component/start)
  (swap! rt component/stop)
  )

(comment
  ;; explore the config...

  (require '[datomic.api :as d])

  (d/q '[:find ?e ?n
           :in $
           :where
           [?e :arachne.http.endpoint/name ?n]]  ;; ??? What should I replace q w/?
      (:db cfg))

  )
