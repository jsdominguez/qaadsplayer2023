Feature: ADS Videos Player

  Scenario: Validar ads video en nota interna AE
    Given Ingreso a la pagina de "AE" en la nota de "https://www.americatv.com.pe/al-fondo-hay-sitio/alessia-decidio-no-viajar-y-tuvo-emotivo-reencuentro-jimmy-noticia-143395"
    When termina de carga la pagina por completo
    Then valido la publicidad en nota interna de video
    And Cierro la pagina

  Scenario: Validar ads video en nota interna AN
    Given Ingreso a la pagina de "AN" en la nota de "https://www.americatv.com.pe/noticias/actualidad/financista-oculto-campana-dina-boluarte-n476604"
    When termina de carga la pagina por completo
    Then valido la publicidad en nota interna de video
    And Cierro la pagina

  Scenario: Validar ads video en nota interna AD
    Given Ingreso a la pagina de "AD" en la nota de "https://www.americatv.com.pe/deportes/futbol-mundial/espana-vencio-penales-croacia-y-conquisto-nations-league-n437497"
    When termina de carga la pagina por completo
    Then valido la publicidad en nota interna de video
    And Cierro la pagina

  Scenario: Validar ads video en nota interna CN
    Given Ingreso a la pagina de "CN" en la nota de "https://canaln.pe/actualidad/luis-solari-estoy-seguro-que-vamos-tener-elecciones-adelantadas-n463124"
    When termina de carga la pagina por completo
    Then valido la publicidad en nota interna de video
    And Cierro la pagina