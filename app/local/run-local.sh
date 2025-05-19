#!/bin/bash

## CONFIGURAÇÕES DE AMBIENTE ##
export JAVA_HOME="/usr/lib/jvm/temurin-21-jdk-amd64"
export M2_HOME="/opt/apache-maven-3.9.6"
export PATH=$JAVA_HOME/bin:$M2_HOME/bin:$PATH

echo "========================================="
echo "Detectando variáveis de ambiente..."
echo "JAVA_HOME: $JAVA_HOME"
echo "M2_HOME: $M2_HOME"
echo "PATH atualizado."
echo "========================================="

# Caminho do template.yml
TEMPLATE="/mnt/d/Projetos/encurtador-link/app/template.yml"

echo "📦 Build da aplicação com SAM..."
sam build -t "$TEMPLATE"

# Verifica se o build foi bem-sucedido
if [ $? -ne 0 ]; then
  echo "❌ Falha ao compilar com SAM. Abortando execução."
  exit 1
fi

echo "🚀 Iniciando API local com SAM..."
sam local start-api \
  -t "$TEMPLATE" \
  --docker-network sam-local-net \
  --warm-containers EAGER
