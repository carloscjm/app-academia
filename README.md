# Academia

App Android pessoal que mostra o treino do dia de um ciclo de 4 semanas (20 treinos).
Ao concluir um treino ele passa para o próximo; depois do último, volta ao primeiro.
Funciona sem internet e guarda o progresso só no aparelho.

## Baixar o APK

Cada push na `main` gera um APK novo pelo GitHub Actions e publica em **Releases**:

https://github.com/carloscjm/app-academia/releases/latest/download/academia.apk

Para atualizar, basta instalar o APK novo por cima do antigo: o progresso é mantido.

## Exercícios

A aba **Exercícios** traz um catálogo com mais de 670 exercícios de musculação (barra, halteres,
máquinas, polia, peso do corpo, kettlebell e outros), com busca e filtro por músculo. Tocando em um
exercício aparecem duas fotos alternando, a posição inicial e a final do movimento, e o botão para
adicioná-lo a um dos treinos, com séries e repetições. Também dá para cadastrar um exercício próprio
(sem foto).

Na tela **Hoje**, **Editar exercícios** permite tirar exercícios do treino do dia e ir à lista para
adicionar outros. A mudança vale para todos os treinos do mesmo tipo no ciclo (por exemplo, todo
"Pernas") e fica salva no aparelho. **Restaurar lista sugerida** volta ao original.

### De onde vêm os exercícios e as fotos

Os dados e as fotos são da base aberta [free-exercise-db](https://github.com/yuhonas/free-exercise-db),
que se declara em domínio público (Unlicense). Os nomes foram traduzidos para o português neste projeto.
As fotos ficam em `app/src/main/assets/ex/` (reduzidas, em WebP) e a lista em
`app/src/main/assets/exercicios.js`.

## Mudar os treinos ou as listas sugeridas

Tudo fica em `app/src/main/assets/index.html`:

- `TREINOS`: os exercícios sugeridos de cada tipo de treino (nome, séries × repetições, id no catálogo).
- `SEMANAS`: a ordem dos treinos nas 4 semanas.

Dá para abrir esse arquivo direto no navegador para ver o resultado antes de gerar o APK.

## Compilar no computador (opcional)

Com o Android SDK instalado: `./gradlew assembleRelease`.
O APK sai em `app/build/outputs/apk/release/app-release.apk`.
