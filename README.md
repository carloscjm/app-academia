# Academia

App Android pessoal que mostra o treino do dia de um ciclo de 4 semanas (20 treinos).
Ao concluir um treino ele passa para o próximo; depois do último, volta ao primeiro.
Funciona sem internet e guarda o progresso só no aparelho.

## Baixar o APK

Cada push na `main` gera um APK novo pelo GitHub Actions e publica em **Releases**:

https://github.com/carloscjm/app-academia/releases/latest/download/academia.apk

Para atualizar, basta instalar o APK novo por cima do antigo: o progresso é mantido.

## Mudar os treinos ou exercícios

Tudo fica em `app/src/main/assets/index.html`:

- `TREINOS`: os exercícios de cada tipo de treino (nome, séries × repetições).
- `SEMANAS`: a ordem dos treinos nas 4 semanas.

Dá para abrir esse arquivo direto no navegador para ver o resultado antes de gerar o APK.

## Compilar no computador (opcional)

Com o Android SDK instalado: `./gradlew assembleRelease`.
O APK sai em `app/build/outputs/apk/release/app-release.apk`.
