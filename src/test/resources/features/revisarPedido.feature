Feature: revisar pedido

  @automatizado @001
  Scenario: Não revisar o pedido sem informar o nome completo
    Given que o usuario realizou o login
    And que ele tenha adicionado um item ao carrinho
    And em entrega tenha informado o nome completo Rebecca Winter, rua Mandorley 112, cidade Truro, cep 89750 e pais United Kingdom
    And em revisar pedido tenha informado o numero do cartão 325812657568789, data de validade 0325 e codigo de segurança 123 e não informou o nome completo
    When o usuario confirmar revisar o pedido
    Then é informado que o nome completo do cartao não foi informado

  @automatizado @002
  Scenario: Não revisar o pedido sem informar o numero do cartao
    Given que o usuario realizou o login
    And que ele tenha adicionado um item ao carrinho
    And em entrega tenha informado o nome completo Rebecca Winter, rua Mandorley 112, cidade Truro, cep 89750 e pais United Kingdom
    And em revisar pedido tenha informado o nome completo Rebecca Winter, data de validade 0325, codigo de segurança 123 e não informou o numero do cartão
    When o usuario confirmar revisar o pedido
    Then é informado que o numero do cartão não foi informado

  @automatizado @003
  Scenario: Não revisar o pedido sem informar a data de validade
    Given que o usuario realizou o login
    And que ele tenha adicionado um item ao carrinho
    And em entrega tenha informado o nome completo Rebecca Winter, rua Mandorley 112, cidade Truro, cep 89750 e pais United Kingdom
    And em revisar pedido tenha informado o nome completo Rebecca Winter, numero do cartão 325812657568789, codigo de segurança 123 e não informou a data de validade
    When o usuario confirmar revisar o pedido
    Then é informado que a data de validade do cartão não foi informado

  @automatizado @004
  Scenario: Não revisar o pedido sem informar o codigo de seguranca
    Given que o usuario realizou o login
    And que ele tenha adicionado um item ao carrinho
    And em entrega tenha informado o nome completo Rebecca Winter, rua Mandorley 112, cidade Truro, cep 89750 e pais United Kingdom
    And em revisar pedido tenha informado o nome completo Rebecca Winter, numero do cartão 325812657568789, data de validade 0325 e não informou o codigo de seguranca
    When o usuario confirmar revisar o pedido
    Then é informado que o codigo de segurança do cartão não foi informado

  @automatizado @005
  Scenario: Não revisar o pedido sem informar o nome de quem recebera a compra quando o endereço de entrega é diferente do usuario
    Given que o usuario realizou o login
    And que ele tenha adicionado um item ao carrinho
    And em entrega tenha informado o nome completo Rebecca Winter, rua Mandorley 112, cidade Truro, cep 89750 e pais United Kingdom
    And em pagamento tenha informado nome titular do cartão Rebecca Winter, numero do cartão 325812657568789, data de validade 0325 e codigo de segurança 123
    And ele não tenha selecionado meu endereço de cobrança é igual ao meu endereço de entrega
    And o usuario informou a rua Mandorley 112, cidade truco, cep 89750, pais United Kingdom e não informou nome completo
    When o usuario confirmar revisar o pedido
    Then é informado que o nome completo não foi informado

  @automatizado @006
  Scenario: Não revisar o pedido sem informar a rua quando o endereço de entrega é diferente do usuario
    Given que o usuario realizou o login
    And que ele tenha adicionado um item ao carrinho
    And em entrega tenha informado o nome completo Rebecca Winter, rua Mandorley 112, cidade Truro, cep 89750 e pais United Kingdom
    And em pagamento tenha informado nome titular do cartão Rebecca Winter, numero do cartão 325812657568789, data de validade 0325 e codigo de segurança 123
    And ele não tenha selecionado meu endereço de cobrança é igual ao meu endereço de entrega
    And o usuario informou o nome completo Obi Wan, cidade truco, cep 89750 e pais United Kingdom e não informa a rua
    When o usuario confirmar revisar o pedido
    Then é informado que a rua não foi informada

  @automatizado @007
  Scenario: Não revisar o pedido sem informar a cidade quando o endereço de entrega é diferente do usuario
    Given que o usuario realizou o login
    And que ele tenha adicionado um item ao carrinho
    And em entrega tenha informado o nome completo Rebecca Winter, rua Mandorley 112, cidade Truro, cep 89750 e pais United Kingdom
    And em pagamento tenha informado nome titular do cartão Rebecca Winter, numero do cartão 325812657568789, data de validade 0325 e codigo de segurança 123
    And ele não tenha selecionado meu endereço de cobrança é igual ao meu endereço de entrega
    And o usuario informou o nome completo Obi Wan, rua Mandorley 112, cep 89750 e pais United Kingdom e não informa a cidade
    When o usuario confirmar revisar o pedido
    Then é informado que a cidade não foi informada


  @automatizado @008
  Scenario: Não revisar o pedido sem informar o codigo postal quando o endereço de entrega é diferente do usuario
    Given que o usuario realizou o login
    And que ele tenha adicionado um item ao carrinho
    And em entrega tenha informado o nome completo Rebecca Winter, rua Mandorley 112, cidade Truro, cep 89750 e pais United Kingdom
    And em pagamento tenha informado nome titular do cartão Rebecca Winter, numero do cartão 325812657568789, data de validade 0325 e codigo de segurança 123
    And ele não tenha selecionado meu endereço de cobrança é igual ao meu endereço de entrega
    And o usuario informou o nome completo Obi Wan, rua Mandorley 112, cidade truro, pais United Kingdom e não informa o codigo postal
    When o usuario confirmar revisar o pedido
    Then é informado que o codigo postal não foi informado

  @automatizado @009
  Scenario: Não revisar o pedido sem informar o pais quando o endereço de entrega é diferente do usuario
    Given que o usuario realizou o login
    And que ele tenha adicionado um item ao carrinho
    And em entrega tenha informado o nome completo Rebecca Winter, rua Mandorley 112, cidade Truro, cep 89750 e pais United Kingdom
    And em pagamento tenha informado nome titular do cartão Rebecca Winter, numero do cartão 325812657568789, data de validade 0325 e codigo de segurança 123
    And ele não tenha selecionado meu endereço de cobrança é igual ao meu endereço de entrega
    And o usuario informou o nome completo Rebecca Winter, rua Mandorley 112, cidade Truro, cep 89750 e não informa o pais
    When o usuario confirmar revisar o pedido
    Then é informado que o pais não foi informado