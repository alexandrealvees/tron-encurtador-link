#!/bin/bash

# 🚀 Detecta se está no WSL ou no Windows
if grep -qEi "(Microsoft|WSL)" /proc/version &> /dev/null ; then
  echo "🌐 Ambiente detectado: WSL"
  PROJECT_DIR=~/encurtador-link
else
  echo "🖥 Ambiente detectado: Windows"
  PROJECT_DIR="/mnt/d/Projetos/encurtador-link"
fi

# 📄 Caminho do template SAM
TEMPLATE="$PROJECT_DIR/app/template.yml"

# 🛠️ Configura Java e Maven (ajuste conforme necessário)
export JAVA_HOME="/usr/lib/jvm/temurin-21-jdk-amd64"
export M2_HOME="/opt/apache-maven-3.9.6"
export PATH="$JAVA_HOME/bin:$M2_HOME/bin:$PATH"

# ℹ️ Exibe variáveis de ambiente
echo "========================================="
echo "JAVA_HOME: $JAVA_HOME"
echo "M2_HOME: $M2_HOME"
echo "PATH: $PATH"
echo "========================================="

# 📦 Build da aplicação com SAM
echo "📦 Executando SAM Build..."
sam build -t "$TEMPLATE"

if [ $? -ne 0 ]; then
  echo "❌ Falha ao compilar com SAM. Abortando execução."
  exit 1
fi

# 🚀 Iniciando a API local
echo "🚀 Iniciando SAM Local API..."
sam local start-api \
  -t "$TEMPLATE" \
  --warm-containers EAGER