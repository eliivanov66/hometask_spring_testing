================== AuthService ======================
help:
   use POST /api/login + RequestParam('name') + RequestParam('password') for login
   use POST /api/register + RequestParam('name') + RequestParam('password') for registration
   use UPDATE /api/logout + RequestParam('id') for logout session with id
   use GET /api/sessions to get all current logged sessions
=====================================================