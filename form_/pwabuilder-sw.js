// // This is the service worker with the combined offline experience (Offline page + Offline copy of pages)

// TODO: Install workBox-build from a command prompt
// TODO:   npm install workbox-build
const workboxBuild = require('workbox-build');
const SRC_DIR = 'src';
const BUILD_DIR = '{1:dist}';
const SW = 'sw.js';

const input ={
  swSrc: `${SRC_DIR}/${SW}`,
  swDest: `${BUILD_DIR}/${SW}`,
  globDirectory: BUILD_DIR,
  globPatterns: [
    '**/*.{js,png,ico,svg,html,css}',
    'assets/**/*'
  ],
  globIgnores: ['sw.js'],
  maximumFileSizeToCacheInBytes: 4000000
};

workboxBuild.injectManifest(input).then(() =>{
  console.log(`The service worker ${BUILD_DIR}/${SW} has been injected with a precache list.`);
});



// const CACHE = "pwabuilder-offline-page";

// importScripts('https://storage.googleapis.com/workbox-cdn/releases/5.1.2/workbox-sw.js');

// // TODO: replace the following with the correct offline fallback page i.e.: const offlineFallbackPage = "offline.html";
// const offlineFallbackPage = "ToDo-replace-this-name.html";

// self.addEventListener("message", (event) => {
//   if (event.data && event.data.type === "SKIP_WAITING") {
//     self.skipWaiting();
//   }
// });

// self.addEventListener('install', async (event) => {
//   event.waitUntil(
//     caches.open(CACHE)
//       .then((cache) => cache.add(offlineFallbackPage))
//   );
// });

// if (workbox.navigationPreload.isSupported()) {
//   workbox.navigationPreload.enable();
// }

// workbox.routing.registerRoute(
//   new RegExp('/*'),
//   new workbox.strategies.StaleWhileRevalidate({
//     cacheName: CACHE
//   })
// );

// self.addEventListener('fetch', (event) => {
//   if (event.request.mode === 'navigate') {
//     event.respondWith((async () => {
//       try {
//         const preloadResp = await event.preloadResponse;

//         if (preloadResp) {
//           return preloadResp;
//         }

//         const networkResp = await fetch(event.request);
//         return networkResp;
//       } catch (error) {

//         const cache = await caches.open(CACHE);
//         const cachedResp = await cache.match(offlineFallbackPage);
//         return cachedResp;
//       }
//     })());
//   }
// });