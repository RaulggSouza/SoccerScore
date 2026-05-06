# SoccerScore

Aplicativo Android desenvolvido em Kotlin com Jetpack Compose e Navigation Compose.

O SoccerScore é um simulador simples de placar de futebol. O usuário informa os dados da partida, visualiza um resumo e confirma o resultado final.

## Objetivo

O objetivo do projeto é praticar o desenvolvimento de um aplicativo Android com três telas, utilizando componentes básicos do Jetpack Compose, navegação entre telas e passagem de parâmetros por rotas.

O aplicativo permite:

- Informar o nome dos dois times;
- Informar a quantidade de gols de cada time;
- Validar os dados digitados;
- Visualizar um resumo da partida;
- Confirmar o resultado final;
- Iniciar um novo jogo.

## Telas do aplicativo

O aplicativo possui três telas principais.

## Tela 1 - Configuração da Partida

A primeira tela é responsável por coletar os dados da partida.

Campos disponíveis:

- Nome do Time A;
- Nome do Time B;
- Gols do Time A;
- Gols do Time B.

Regras de validação:

- Todos os campos devem ser preenchidos;
- Os gols devem ser valores numéricos inteiros;
- Os gols devem ser maiores ou iguais a zero.

Ao clicar no botão **Ver Resultado**, o aplicativo valida os dados digitados. Caso os dados estejam corretos, ocorre a navegação para a segunda tela, passando os parâmetros informados pelo usuário.

## Tela 2 - Resumo da Partida

A segunda tela exibe um resumo da partida com os dados preenchidos na primeira tela.

Informações exibidas:

- Nome dos times;
- Placar da partida.

A tela possui dois botões:

- **Confirmar Resultado**: navega para a terceira tela;
- **Editar**: retorna para a primeira tela para alterar os dados.

## Tela 3 - Resultado Final

A terceira tela exibe o resultado final da partida.

Regras de resultado:

- Se o Time A tiver mais gols que o Time B, será exibida uma mensagem informando que o Time A venceu;
- Se o Time B tiver mais gols que o Time A, será exibida uma mensagem informando que o Time B venceu;
- Se os dois times tiverem a mesma quantidade de gols, será exibida a mensagem de empate.

A tela possui o botão **Novo Jogo**, que retorna para a primeira tela para iniciar uma nova partida.

## Fluxo de navegação

O fluxo principal do aplicativo é:

Tela 1 -> Tela 2 -> Tela 3

Também existem os seguintes retornos:

Tela 2 -> Tela 1  
Tela 3 -> Tela 1

A navegação é feita utilizando Navigation Compose.

## Parâmetros utilizados

Os dados da partida são enviados entre as telas por meio de parâmetros nas rotas.

Parâmetros utilizados:

- teamA;
- teamB;
- golsA;
- golsB.

Na primeira tela, os valores dos gols são digitados como texto. Após a validação, eles são convertidos de String para Int para serem utilizados nas telas seguintes.

## Validações implementadas

Antes de navegar para a tela de resumo, o aplicativo verifica se os dados foram preenchidos corretamente.

Validações realizadas:

- Verifica se o nome do Time A está preenchido;
- Verifica se o nome do Time B está preenchido;
- Verifica se os gols do Time A foram preenchidos;
- Verifica se os gols do Time B foram preenchidos;
- Verifica se os gols são números inteiros;
- Verifica se os gols são maiores ou iguais a zero.

Caso algum campo esteja inválido, uma mensagem de erro é exibida abaixo do campo correspondente.

## Preservação de estado

O projeto utiliza `rememberSaveable` para preservar os dados digitados quando ocorre uma mudança de configuração, como a rotação da tela.

Isso evita que os dados informados pelo usuário sejam perdidos quando a interface é recriada.

## Autor

Nome: Raul Souza  
Prontuário: SC3045153  
Disciplina: Programação para Dispositivos Móveis
