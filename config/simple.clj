(require '[arachne.core.dsl :as core])

(core/runtime :arachne-demo-1/runtime [:arachne-demo-1/ticktock
                                       :arachne-demo-1/ticktock2
                                       ])

(core/component :arachne-demo-1/ticktock {}
  'arachne-demo-1.ticktock/->TickTock)
