def call(){
  sh '''
        # Old deployment through Dockerfile
        # docker rm -f codealpha-webserver || true
        # docker run -d -p 9090:80 \
        #   --name codealpha-webserver \
        #   codealpha-webserver:latest

        # New deployment through docker compose 

        set +e

        echo "Stopping old compose stack..."
        docker compose down || true

        echo "Removing old container if exists..."
        docker rm -f codealpha-webserver || true

        echo "Starting new deployment..."
        docker compose up -d --build

        set -e
        '''
}
