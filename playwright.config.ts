import { defineConfig, devices } from '@playwright/test';

export default defineConfig({
    // Look for test files in the "tests" directory, relative to this configuration file.
    testDir: 'tests',

    // Run all tests in parallel.
    fullyParallel: true,

    // Fail the build on CI if you accidentally left test.only in the source code.
    forbidOnly: !!process.env.CI,

    // Retry on CI only.
    retries: process.env.CI ? 2 : 0,

    // Opt out of parallel tests on CI.
    workers: process.env.CI ? 5 : 3,

    /* Reporter to use. See https://playwright.dev/docs/test-reporters */
    reporter: process.env.CI
        ? [['dot'], ['allure-playwright']]
        : [['list'], ['html', { open: 'on-failure' }]],

    /* Shared settings for all the projects below. See https://playwright.dev/docs/api/class-testoptions. */
    use: {
        /* Maximum time each action such as `click()` can take. Defaults to 0 (no limit). */
        actionTimeout: 30000,

        /* For local execution turn on trace, for CI execution, trace will be recorded after the first retry */
        trace: process.env.CI ? 'retain-on-failure' : 'on',

        /* For CI execution will be recorded video as evidence, and for local will be recorded if test will fail */
        video: {
            mode: process.env.CI ? 'on' : 'on',
            size: { width: 1920, height: 1020 },
        },

        /* Viewport of the browser in whch tests will be executed */
        viewport: { width: 1920, height: 1080 },

        /* Screenshots will be created on the end of the test for CI execution and if failed for local execution*/
        screenshot: process.env.CI ? 'on' : 'only-on-failure',
        acceptDownloads: true,

        /**
         * Geolocation
         */
        locale: 'de-Ger',
        geolocation: { longitude: 12.492507, latitude: 41.889938 },
        timezoneId: 'de-Ger',
        permissions: ['geolocation'],
    },

    // Configure projects for major browsers.
    projects: [
        {
            name: 'chromium',
            use: {
                ...devices['Desktop Chrome'],
                baseURL: 'http://develop.simplardev.telekom.de/auth',
            },
        },
        /* Test against branded browsers. */
        {
            name: 'Google Chrome',
            use: { ...devices['Desktop Chrome'], channel: 'chrome' }, // or 'chrome-beta'
        },
        {
            name: 'Microsoft Edge',
            use: { ...devices['Desktop Edge'], channel: 'msedge' }, // or 'msedge-dev'
        },

    ],
    // Run your local dev server before starting the tests.
    webServer: {
        command: 'npm run start',
        url: 'http://127.0.0.1:3000',
        reuseExistingServer: !process.env.CI,
    },
});