Feature: checkout pedido

  @automatizado @001
  Scenario: Não realizar o checkout sem informar o nome de quem recebera a compra
    Given que o usuario realizou o login
    And que ele tenha adicionado um item ao carrinho
    And em checkout informou a rua Mandorley 112, cidade truco, cep 89750 e pais United Kingdom e não informou nome completo
    When o usuario confirmar para ir ao pagamento
    Then é informado que o nome completo não foi informado

  @automatizado @002
  Scenario: Não realizar o checkout sem informar a rua de entrega da compra
    Given que o usuario realizou o login
    And que ele tenha adicionado um item ao carrinho
    And em checkout informou o nome completo Obi Wan, cidade truco, cep 89750 e pais United Kingdom e não informa a rua
    When o usuario confirmar para ir ao pagamento
    Then é informado que a rua não foi informada

  @automatizado @003
  Scenario: Não realizar o checkout sem informar a cidade de entrega da compra
    Given que o usuario realizou o login
    And que ele tenha adicionado um item ao carrinho
    And em checkout informou o nome completo Vladis Steppe, rua Mandorley 112, cep 89750, pais Romenia e não informou a cidade
    When o usuario confirmar para ir ao pagamento
    Then é informado que a cidade não foi informada

  @automatizado @004
  Scenario: Não realizar o checkout sem informar o codigo postal da entrega da compra
    Given que o usuario realizou o login
    And que ele tenha adicionado um item ao carrinho
    And em check out informou o nome completo Neo Geo, rua Mandorley 112, cidade Tokyo, pais Japan e não informou o codigo postal
    When o usuario confirmar para ir ao pagamento
    Then é informado que o codigo postal não foi informado

  @automatizado @005
  Scenario: Não realizar o checkout sem informar o pais da entrega da compra
    Given que o usuario realizou o login
    And que ele tenha adicionado um item ao carrinho
    And em checkout informou o nome completo Neo Geo, rua Mandorley 112, cidade Tokyo, zip code 89750 e não informou o pais
    When o usuario confirmar para ir ao pagamento
    Then é informado que o pais não foi informado