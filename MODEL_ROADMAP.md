# AI model roadmap for AI Enhance Studio

## Phase 1 — Prototype (phone only)
- Build and install the Android shell.
- Confirm gallery video selection works.
- Deploy the backend only after adding authentication and secure temporary storage.
- Test upload/download with a tiny, non-private sample clip.

## Phase 2 — Research an open-source baseline
A practical research baseline is Real-ESRGAN for frame/image restoration. Review its license and dependencies before integrating or distributing it:
https://github.com/xinntao/Real-ESRGAN

This is not a complete temporal video enhancer. Frame-by-frame enhancement can cause flicker.

## Phase 3 — Train/fine-tune in a cloud GPU environment
- Use a cloud GPU notebook or rented GPU; a phone alone is not suitable for training a video super-resolution model.
- Use footage you own or have permission to use.
- Prepare low-resolution/high-resolution frame pairs and train/validate/test splits.
- Record model version, dataset provenance, GPU cost and quality metrics.
- Never expose cloud credentials in the mobile app or public notebook.

## Phase 4 — Video pipeline
1. Validate file type and size.
2. Decode video into frames with FFmpeg.
3. Run model inference in batches on a GPU worker.
4. Preserve frame order and timestamps; evaluate flicker.
5. Re-encode frames and preserve audio where appropriate.
6. Return a temporary download link and delete source/output files automatically.

## Phase 5 — Release checks
- Authentication and per-user quotas.
- Upload limits, timeouts and cancellation.
- Private storage and automatic deletion.
- Test supported resolutions and codecs.
- Validate model and dataset licenses.
- Measure cost per minute before offering unlimited use.
