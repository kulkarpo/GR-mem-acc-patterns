COMPONENT=pojo
VERSION=1.2

echo Building component $COMPONENT at version $VERSION
cd src/$COMPONENT

IMAGE=patrocinio/memoryleak:$VERSION
docker build -t $IMAGE .

