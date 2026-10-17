# AI Enhance Studio — Android starter

This is a starter project for an Android video-enhancement app. It is **not yet a working AI enhancer**:
the Android app can select a video and submit it to a backend endpoint, but the backend's model inference is intentionally a placeholder.

## Phone-only workflow

1. Download and unzip this project on your Android phone.
2. Create a GitHub repository and upload the contents of this folder.
3. Open the repository's **Actions** tab. The included workflow builds a debug APK in the cloud.
4. Download the APK artifact from a successful workflow run and install it on your Android phone.
5. To run real enhancement, deploy the backend to a server and connect a real model/inference worker.

## What is included

- `android/`: minimal Kotlin Android app.
- `backend/`: FastAPI backend starter with upload/job endpoints; inference is not implemented.
- `.github/workflows/android-apk.yml`: cloud APK build workflow.
- `MODEL_ROADMAP.md`: practical path to training and deploying your own model.

## Important limitations

- This project does not contain a trained AI model or GPU worker.
- The backend starter does not enhance videos yet; it returns an explicit `NOT_IMPLEMENTED` status.
- Do not put API keys or secrets inside the Android APK. Keep them in backend environment variables.
- Do not upload private videos until you have deployed a secure backend with authentication, size limits, temporary storage and automatic deletion.
- A debug APK is for testing, not public release.

## Build notes

The Android project uses Gradle and Android SDK through GitHub Actions. If GitHub's hosted runner or dependency versions change, the workflow may need updating.

The included GitHub Actions workflow installs Gradle on the runner, so no wrapper JAR is required for this starter.
