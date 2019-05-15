COMPONENT=memoryleak
VERSION=1.2

IMAGE=patrocinio/$COMPONENT:$VERSION

echo Pushing component $COMPONENT as latest version
LATEST=patrocinio/$COMPONENT:latest
docker tag $IMAGE $LATEST
docker push $LATEST

echo Pushing component $COMPONENT as version $VERSION
docker tag $IMAGE $IMAGE
docker push $IMAGE
