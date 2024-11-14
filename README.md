# Console-social-media-application

Run the Spring boot application first.

Then Run this command to register =>> curl -X POST "http://localhost:8082/users/register?userId=1&username=Karthik"

Run this command to upload curl -X POST "http://localhost:8082/posts/upload?userId=1&content=This+is+my+first+post"

Run this command to follow user curl -X POST "http://localhost:8082/users/1/follow/2"

Run this command to unfollow user curl -X POST "http://localhost:8082/users/1/unfollow/2"

Run this command to fetch the feed curl -X GET "http://localhost:8082/users/1/feed"

Run this command to Like a Post curl -X POST "http://localhost:8082/posts/interact?interactionType=LIKE&userId=1&postId="

Run this command to dislike a Post curl -X POST "http://localhost:8082/posts/interact?interactionType=DISLIKE&userId=1&postId="

Run this command to unlike a Post curl -X POST "http://localhost:8082/posts/interact?interactionType=UNLIKE&userId=1&postId="

Run this command to undislike a post curl -X POST "http://localhost:8082/posts/interact?interactionType=UNDISLIKE&userId=1&postId="

Run this command to Display Relative Time  curl -X GET "http://localhost:8082/users/1/feedInfo"
